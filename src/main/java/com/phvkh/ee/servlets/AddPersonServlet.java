package com.phvkh.ee.servlets;

import com.phvkh.ee.database.PeopleRepository;
import com.phvkh.ee.dto.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddPersonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("jsp/add_person.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Person person = new Person(req.getParameter("name"),
                req.getParameter("lastName"),
                req.getParameter("patronymic"),
                req.getParameter("date"));
        PeopleRepository.getInstance().addPerson(person);
        resp.sendRedirect("all");
    }
}