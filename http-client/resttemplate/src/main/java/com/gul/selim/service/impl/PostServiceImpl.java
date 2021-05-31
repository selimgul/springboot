package com.gul.selim.service.impl;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import com.gul.selim.model.Post;
import com.gul.selim.service.PostService;

@Service
public class PostServiceImpl extends ServiceBaseImpl implements PostService {

	@Override
	public List<Post> getPosts() {
		uriHelper.setEndpoint(endpointConfig.getGetPostsEndpoint());
		//return Arrays.asList(reqHelper.get(securityConfig.getBasicAuthUser(), uriHelper.toString(), Post[].class).getBody());
		return reqHelper.get(securityConfig.getBasicAuthUser(), uriHelper.toString(), new ParameterizedTypeReference<List<Post>>(){}).getBody();		
	}
	
	@Override
	public Post getPostById(String id) {
		uriHelper.setEndpoint(endpointConfig.getGetPostByIdEndpoint());		
		uriHelper.addPathParam("id", id);
		return reqHelper.get(securityConfig.getBasicAuthUser(), uriHelper.toString(), Post.class).getBody();
	}

	@Override
	public Post createPost(Post post) {
		uriHelper.setEndpoint(endpointConfig.getCreatePostEndpoint());		
		return reqHelper.post(securityConfig.getBasicAuthUser(), uriHelper.toString(), post, Post.class).getBody();
	}

}
