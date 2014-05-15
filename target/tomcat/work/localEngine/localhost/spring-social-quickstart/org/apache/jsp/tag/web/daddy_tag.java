package org.apache.jsp.tag.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class daddy_tag
    extends javax.servlet.jsp.tagext.SimpleTagSupport
    implements org.apache.jasper.runtime.JspSourceDependent {


  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private JspContext jspContext;
  private java.io.Writer _jspx_sout;
  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public void setJspContext(JspContext ctx) {
    super.setJspContext(ctx);
    java.util.ArrayList _jspx_nested = null;
    java.util.ArrayList _jspx_at_begin = null;
    java.util.ArrayList _jspx_at_end = null;
    this.jspContext = new org.apache.jasper.runtime.JspContextWrapper(ctx, _jspx_nested, _jspx_at_begin, _jspx_at_end, null);
  }

  public JspContext getJspContext() {
    return this.jspContext;
  }
  private java.lang.String pageNumber;

  public java.lang.String getPageNumber() {
    return this.pageNumber;
  }

  public void setPageNumber(java.lang.String pageNumber) {
    this.pageNumber = pageNumber;
    jspContext.setAttribute("pageNumber", pageNumber);
  }

  public Object getDependants() {
    return _jspx_dependants;
  }

  private void _jspInit(ServletConfig config) {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(config.getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) config.getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void doTag() throws JspException, java.io.IOException {
    PageContext _jspx_page_context = (PageContext)jspContext;
    HttpServletRequest request = (HttpServletRequest) _jspx_page_context.getRequest();
    HttpServletResponse response = (HttpServletResponse) _jspx_page_context.getResponse();
    HttpSession session = _jspx_page_context.getSession();
    ServletContext application = _jspx_page_context.getServletContext();
    ServletConfig config = _jspx_page_context.getServletConfig();
    JspWriter out = jspContext.getOut();
    _jspInit(config);
    jspContext.getELContext().putContext(JspContext.class,jspContext);
    if( getPageNumber() != null ) 
      _jspx_page_context.setAttribute("pageNumber", getPageNumber());

    try {
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(request.getContextPath());
      out.write("/resources/css/bootstrap.css\" />\n");
      out.write("<link rel=\"stylesheet/less\" type=\"text/css\" href=\"");
      out.print(request.getContextPath());
      out.write("/resources/css/template.less\" />\n");
      out.write("<title>Let the bidding begin ...</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("\t<div class=\"container\">\n");
      out.write("\t\t<div class=\"navbar navbar-default\">\n");
      out.write("                <div class=\"navbar-header\">\n");
      out.write("                  <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-responsive-collapse\">\n");
      out.write("                    <span class=\"icon-bar\"></span>\n");
      out.write("                    <span class=\"icon-bar\"></span>\n");
      out.write("                    <span class=\"icon-bar\"></span>\n");
      out.write("                  </button>\n");
      out.write("                  <a class=\"navbar-brand\" href=\"bidwithcoins\">home</a>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"navbar-collapse collapse navbar-responsive-collapse\">\n");
      out.write("                  <ul class=\"nav navbar-nav\">\n");
      out.write("                    <li class=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageNumber == 1 ? 'active' : ''}", java.lang.String.class, (PageContext)this.getJspContext(), null, false));
      out.write("\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/pen\" >pen</a></li>\n");
      out.write("                    <li class=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageNumber == 2 ? 'active' : ''}", java.lang.String.class, (PageContext)this.getJspContext(), null, false));
      out.write("\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/brush\" >brush</a></li>\n");
      out.write("                  </ul>\n");
      out.write("                  <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                  \t<li class=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageNumber == 3 ? 'active' : ''}", java.lang.String.class, (PageContext)this.getJspContext(), null, false));
      out.write("\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/account\" >account</a></li>\n");
      out.write("                    <li class=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageNumber == 4 ? 'active' : ''}", java.lang.String.class, (PageContext)this.getJspContext(), null, false));
      out.write("\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/sign\" >signin</a></li>\n");
      out.write("                    <li class=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageNumber == 5 ? 'active' : ''}", java.lang.String.class, (PageContext)this.getJspContext(), null, false));
      out.write("\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/signup\" >signup</a></li>\n");
      out.write("                  </ul>\n");
      out.write("                </div><!-- /.nav-collapse -->\n");
      out.write("              </div>\n");
      out.write("\t");
      ((org.apache.jasper.runtime.JspContextWrapper) this.jspContext).syncBeforeInvoke();
      _jspx_sout = null;
      if (getJspBody() != null)
        getJspBody().invoke(_jspx_sout);
      jspContext.getELContext().putContext(JspContext.class,getJspContext());
      out.write("\n");
      out.write("\t</div>\n");
      out.write("\t<script src=\"");
      out.print(request.getContextPath());
      out.write("/resources/js/less.js\" type=\"text/javascript\"></script>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch( Throwable t ) {
      if( t instanceof SkipPageException )
          throw (SkipPageException) t;
      if( t instanceof java.io.IOException )
          throw (java.io.IOException) t;
      if( t instanceof IllegalStateException )
          throw (IllegalStateException) t;
      if( t instanceof JspException )
          throw (JspException) t;
      throw new JspException(t);
    } finally {
      jspContext.getELContext().putContext(JspContext.class,super.getJspContext());
      ((org.apache.jasper.runtime.JspContextWrapper) jspContext).syncEndTagFile();
    }
  }
}
