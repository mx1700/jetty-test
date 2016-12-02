package me.mx1700.servlet

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "HelloServlet", urlPatterns = arrayOf("/hello"))
class HelloServlet : HttpServlet() {

    override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        val out = response.writer
        out.println("<h1>hello world!</h1>")
    }
}