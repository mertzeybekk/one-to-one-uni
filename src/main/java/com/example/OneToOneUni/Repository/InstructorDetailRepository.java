package com.example.OneToOneUni.Repository;

import com.example.OneToOneUni.Entity.InstructorDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorDetailRepository extends JpaRepository<InstructorDetail,Long> {
}
