package com.phvkh.ee.servlets;

import com.phvkh.ee.dto.AddressDTO;
import com.phvkh.ee.dto.PersonDTO;
import com.phvkh.ee.service.AddressPersonService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

@WebServlet("/all")
public class ListOfPeopleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<AddressDTO, Set<PersonDTO>> resultSet = AddressPersonService.getAllAddressesWithPeople();
        req.setAttribute("resultSet", resultSet);
        req.getRequestDispatcher("jsp/all_people.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}