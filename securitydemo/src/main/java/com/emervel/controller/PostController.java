package com.emervel.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by guopm on 03/06/2017.
 */
@RestController
@RequestMapping("/posts")
public class PostController {

    @Secured("ROLE_GUEST")
    @RequestMapping("/list")
    public String list() {
        return "list of post...";
    }

    @Secured("ROLE_USER")
    @RequestMapping("/drafts")
    public String drafts() {
        return "list of post draft...";
    }

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @RequestMapping("/filter")
    public String filtrar() {
        return "list of post filtrados...";
    }
    @Secured("ROLE_ADMIN")
    @RequestMapping("/add")
    public String add() {
        return "add a post";
    }
}
