package com.nems.revctx.resources.submission;

import com.nems.revctx.domainmodel.submission.Submission;
import com.nems.revctx.domainmodel.submission.SubmissionRevision;
import com.nems.revctx.repository.submission.SubmissionRepository;
import com.nems.revctx.services.submission.SubmissionService;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServerRequest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.glassfish.jersey.server.ContainerRequest;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by NE281900 on 4/9/2016.
 */
@Path("submission/{queryString}")
public class SubmissionResource {
    private static final Logger logger = LogManager.getLogger("SubmissionResource");
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public void getQuery(
            @Suspended final AsyncResponse response,
            @Context ContainerRequest jerseyRequest,
            @Context HttpServerRequest vertxRequest,
            @Context Vertx vertx,
            @PathParam("queryString")String queryString) {
        System.out.println(queryString);
        System.out.println(vertx.isMetricsEnabled());
        System.out.println(vertx.isClustered());

        vertx.runOnContext(aVoid -> {
            SubmissionRepository repository = new SubmissionRepository();
            Session session = repository.getSession();
            FullTextSession fullTextSession = Search.getFullTextSession(session);
            Transaction tx = fullTextSession.beginTransaction();
// create native Lucene query using the query DSL
// alternatively you can write the Lucene query using the Lucene query parser
// or the Lucene programmatic API. The Hibernate Search DSL is recommended though
            QueryBuilder qb = fullTextSession.getSearchFactory()
                    .buildQueryBuilder().forEntity(Submission.class).get();
            org.apache.lucene.search.Query query = qb
                    .keyword()
                    .onFields("prism_issn","evise_sub_id","evise_journalSubmissionId","pii")
                    .matching(queryString)
                    .createQuery();
// wrap Lucene query in a org.hibernate.Query
            org.hibernate.Query hibQuery =
                    fullTextSession.createFullTextQuery(query, Submission.class);

            List result = hibQuery.list();
            System.out.println(result.size());
            Submission submission = (Submission) result.get(0);
            System.out.println(submission.getEvise_journalSubmissionId());
            for(SubmissionRevision sr : submission.getSubmissionRevisions()){
                System.out.println(sr.getFull_title());
            }

            tx.commit();
            session.close();
            response.resume(submission);
        });
    }
}
