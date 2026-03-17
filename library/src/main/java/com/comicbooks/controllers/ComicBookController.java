package com.comicbooks.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import com.comicbooks.services.ComicBookService;
import com.comicbooks.models.ComicBook;



@Controller
@RequestMapping("/comicbooks")
public class ComicBookController {
    
    private final ComicBookService comicBookService;

    public ComicBookController(ComicBookService comicBookService) {
        this.comicBookService = comicBookService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("comicBooks", comicBookService.getAllComicBooks());
        return "comicbooks/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("comicBook", new ComicBook());
        return "comicbooks/create";
    }

    @PostMapping("/create")
    public String create(ComicBook comicBook) {
        comicBookService.saveComicBook(comicBook);
        return "redirect:/comicbooks";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("comicBook", comicBookService.getComicBookById(id));
        return "comicbooks/edit";
}

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Long id, ComicBook comicBook) {
        comicBook.setId(id);
        comicBookService.saveComicBook(comicBook);
        return "redirect:/comicbooks";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        comicBookService.deleteComicBook(id);
        return "redirect:/comicbooks";
    }
   

}
