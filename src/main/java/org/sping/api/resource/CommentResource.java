package org.sping.api.resource;

import org.sping.api.model.Comment;
import org.sping.api.model.Response;
import org.sping.api.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value="/comment")
public class CommentResource {

    @Autowired
    CommentRepository commentRepository;

    @GetMapping(value="/all")
    public Response getAllComments(){
        Response response = new Response();
        response.setMessage("Request Completed Successfully");
        response.setData(commentRepository.findAll());
        return response;
    }

    @GetMapping(value="/blogId/{blogId}")
    public Response getCommentByBlogId(@PathVariable final Integer blogId){
        Response response = new Response();
            response.setMessage("Request Completed Successfully");
            response.setData(commentRepository.getCommentByBlogId(blogId));
        return response;
    }

    @PutMapping(value="/update/{id}")
    public Response updateCommentById(@PathVariable final Integer id, @RequestBody final Comment comment){
            Comment comment1 = commentRepository.findOne(id);
        if (comment1==null) {
            Response response = new Response();
            response.setMessage("Error Username Not Found");
            return response;
        }
        comment1.setText(comment.getText());
        commentRepository.save(comment1);
        Response response = new Response();
        response.setMessage("Request Completed Successfully");
        response.setData(commentRepository.findOne(id));
        return response;
    }

    @PostMapping(value="/create")
    public Response createComment(@RequestBody final Comment comment){
        Comment comment1 = commentRepository.save(comment);
        Response response = new Response();
        response.setMessage("Request Completed Successfully");
        response.setData(comment1);
        return response;
    }

    @DeleteMapping(value="/delete/{id}")
    public Response deleteCommentById(@PathVariable final Integer id){
        commentRepository.delete(id);
        Response response = new Response();
        response.setMessage("Request Completed Successfully");
        return response;
    }
}
