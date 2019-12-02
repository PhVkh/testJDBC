package com.phvkh.ee.servlets;

import com.phvkh.ee.database.PeopleRepository;
import com.phvkh.ee.dto.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/all")
public class ListOfPeopleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Person> resultSet = PeopleRepository.getInstance().showAll();
        req.setAttribute("resultSet", resultSet);
        req.getRequestDispatcher("jsp/all_people.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}