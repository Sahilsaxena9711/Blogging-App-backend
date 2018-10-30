package org.sping.api.repository;


import org.sping.api.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> getByUserName(String userName);

    Object getByTitle(String title);
}
