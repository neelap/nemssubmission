package com.nems.revctx.utils;

import com.nems.revctx.repository.submission.SubmissionRepository;
import org.hibernate.Session;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;


/**
 * Created by NE281900 on 4/18/2016.
 */
public class RebuildIndex {
    public static void main(String args[]){
        SubmissionRepository repository = new SubmissionRepository();
        Session session = repository.getSession();
        FullTextSession fullTextSession = Search.getFullTextSession(session);
        try {
            fullTextSession.createIndexer().startAndWait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
