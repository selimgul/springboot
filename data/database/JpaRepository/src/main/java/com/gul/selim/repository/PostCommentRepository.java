package com.gul.selim.repository;

import com.gul.selim.model.Post;
import com.gul.selim.model.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostCommentRepository extends JpaRepository<PostComment, Integer> {
}
