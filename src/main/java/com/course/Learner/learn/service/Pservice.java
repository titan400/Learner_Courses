package com.course.Learner.learn.service;

import com.course.Learner.course.model.Courses;
import com.course.Learner.course.repo.Crepo;
import com.course.Learner.learn.model.Learners;
import com.course.Learner.learn.repo.Trepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Pservice {
    public Trepo trepo;
    @Autowired
    public Pservice(Trepo trepo) {
        this.trepo = trepo;
    }

    public String savedLearners(Learners learners) {
        Learners lc = trepo.save(learners);
        return "Learnings:"+ lc;
    }

    public List<Learners> findLearners()
    {
        return trepo.findAll();
    }
    public Learners getLearnersById(int id)
    {
        return trepo.findById(id);
    }
    public String deleteLearnerById(int id)
    {
        trepo.deleteById(id);
        return "Item deleted with id:"+ (int)id;
    }
    public String deleteAllLearners()
    {
        trepo.deleteAll();
        return "all items deleted";
    }
    public boolean LearnerExistence(int id)
    {
       return trepo.existsById(id);
    }
    public long countLearners()
    {
        return trepo.count();
    }
}
