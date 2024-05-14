package org.example.blogengine.service.implementation;

import org.example.blogengine.model.Post;
import org.example.blogengine.model.User;
import org.example.blogengine.repository.PostRepository;
import org.example.blogengine.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class PostServiceImplementation implements PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostServiceImplementation(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Optional<Post> findForId(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public Post save(Post post) {
        return postRepository.saveAndFlush(post);
    }

    @Override
    public Page<Post> findByUserOrderedByDatePageable(User user, int page) {
        return null;
    }

    @Override
    public Page<Post> findAllOrderedByDatePageable(int page) {
        return null;
    }


//    @Override
//    public Page<Post> findByUserOrderedByDatePageable(User user, int page) {
//        return postRepository.findByUserOrderByCreateDateDesc(user, new PageRequest(subtractPageByOne(page), 5));
//    }
//
//    @Override
//    public Page<Post> findAllOrderedByDatePageable(int page) {
//        return postRepository.findAllByOrderByCreateDateDesc(new PageRequest(subtractPageByOne(page), 5));
//    }

    @Override
    public void delete(Post post) {
        postRepository.delete(post);
    }

    private int subtractPageByOne(int page){
        return (page < 1) ? 0 : page - 1;
    }
}
