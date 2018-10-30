package org.sping.api.resource;

import org.sping.api.model.Blog;
import org.sping.api.model.Response;
import org.sping.api.model.Users;
import org.sping.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/user")
public class UserResource {

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/all")
    public Response getAll(){
            Response response = new Response();
            response.setMessage("Request Completed Successfully");
            response.setData(userRepository.findAll());
        return response;
    }

    @GetMapping(value = "/userName/{userName}")
    public Response findByUserName(@PathVariable final String userName){
        Users user = userRepository.findByUserName(userName);
        Response response = new Response();
            response.setMessage("Request Completed Successfully");
            response.setData(user);
        return response;
    }

    @PostMapping(value = "/create")
    public Response createUser(@RequestBody final Users users){
        Users user = userRepository.findByUserName(users.getUserName());
            if(user == null){
                userRepository.save(users);
                Users result = userRepository.findByUserName(users.getUserName());
                Response response = new Response();
                response.setMessage("User Created Successfully");
                response.setData(result);
                return response;
            }
        Response response = new Response();
        response.setMessage("Username already exists");
        return response;
    }

    @DeleteMapping(value = "/delete/{id}")
    public Response deleteUserById(@PathVariable final Integer id){
            userRepository.delete(id);
            Response response = new Response();
            response.setMessage("User deleted successfully");
         return response;
    }

    @PutMapping(value="/update/{id}")
    public Response updateUserByUserName(@PathVariable final Integer id, @RequestBody final Users users){
        Users result = userRepository.findOne(id);
        if (result==null) {
              Response response = new Response();
              response.setMessage("Error Username Not Found");
            return response;
        }
        result.setEmail(users.getEmail());
        result.setPassword(users.getPassword());
        userRepository.save(result);
        Response response = new Response();
        response.setMessage("Request Completed Successfully");
        response.setData(userRepository.getOne(id));
        return response;
    }


}
