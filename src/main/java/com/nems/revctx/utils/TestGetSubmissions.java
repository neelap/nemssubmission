package com.nems.revctx.utils;

import com.nems.revctx.domainmodel.submission.Submission;
import com.nems.revctx.domainmodel.submission.SubmissionRevision;
import com.nems.revctx.repository.submission.SubmissionRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;

import java.util.List;

/**
 * Created by NE281900 on 4/18/2016.
 */
public class TestGetSubmissions {
    public static void main(String args[]){
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
                .matching("ALCOHOL_PII_3")
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


    }
}
