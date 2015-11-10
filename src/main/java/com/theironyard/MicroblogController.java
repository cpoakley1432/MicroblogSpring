package com.theironyard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Created by cameronoakley on 11/9/15.
 */
@Controller
public class MicroblogController {
    ArrayList<Message> messagelist = new ArrayList();

    @RequestMapping ("/")
    public String home (Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        model.addAttribute("username" , username);
        model.addAttribute("message" , messagelist );
        return "home";
    }

    @RequestMapping ("/login")
    public String login (HttpServletRequest request , String username){
        HttpSession session = request.getSession();
        session.setAttribute("username" , username);
        return "redirect:/";
    }
    @RequestMapping ("/enter-message")
    public String message (String message){
        Message messages = new Message(messagelist.size()+1, message);
        messagelist.add(messages);
        return "redirect:/";
    }
    @RequestMapping ("/delete-message")
    public String deletemessage (Integer id){
        messagelist.remove(id - 1);
        int messagecount = 1;
        for (Message message : messagelist){
            message.id = messagecount;
            messagecount++;
        }
        return "redirect:/";

    }
}
