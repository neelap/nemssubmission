package com.nems.revctx.repository.submission;

/**
 * Created by NE281900 on 4/9/2016.
 */
import com.nems.revctx.domainmodel.submission.Submission;
import com.nems.revctx.domainmodel.submission.SubmissionRevision;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

/**
 * Created by NE281900 on 4/6/2016.
 */
public class SubmissionRepository {
    private static final SessionFactory ourSessionFactory;
    private static final ServiceRegistry serviceRegistry;
    private Session currentSession = null;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            serviceRegistry = new StandardServiceRegistryBuilder().configure().loadProperties("hibernate.cfg.xml").build();
            ourSessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public SubmissionRepository() {
    }

    public  Session getSession() throws HibernateException {
        if(currentSession == null) {
            currentSession = ourSessionFactory.openSession();
        }
        return currentSession;
    }

    public void saveSubmission(Submission submissionEntity){
        Transaction transaction = getSession().beginTransaction();
        getSession().save(submissionEntity);
        transaction.commit();
        getSession().close();
    }

    public void saveSubmissionRevision(SubmissionRevision submissionRevisionEntity){
        Transaction transaction = getSession().beginTransaction();
        getSession().save(submissionRevisionEntity);
        transaction.commit();
        getSession().close();
    }

    public Submission getSubmissionEntity(String journalSubmissionID){
        return (Submission)getSession().createQuery("from Submission where journalSubmissionID = " + journalSubmissionID);
    }


    public List<Submission> getSubmissionEntities(){
        return (List<Submission>)(getSession().createQuery("from Submission").list());
    }


}
