package scalatohoku

import org.scalatra._
import scalate.ScalateSupport

class SimpleServlet extends ScalatraServlet with ScalateSupport {

  override protected def createTemplateEngine(config: Config) = {
    import org.fusesource.scalate.{Binding, TemplateEngine}
    import org.fusesource.scalate.layout.DefaultLayoutStrategy
    import org.fusesource.scalate.servlet.{ServletResourceLoader, ServletRenderContext}
    val te = new TemplateEngine with CreatesServletRenderContext
    te.bindings = List(Binding("context", classOf[ServletRenderContext].getName, true, isImplicit = true))
    te.resourceLoader = new ServletResourceLoader(getServletContext)
    te.layoutStrategy = new DefaultLayoutStrategy(te, TemplateEngine.templateTypes.map("WEB-INF/scalate/layouts/default." + _):_*)
    te
  }

  before {contentType = "text/html"}
  
  get("/") { 
    <html><body><h1>Hello!</h1></body></html>
  }
  
  get("/time") {
    templateEngine.layout("/time.mustache", Map("time" -> new java.util.Date))
  }
  
  get("/hackers") {
    val hackers = Seq(
      Map("name"->"keisuke_n","site"->"http://cappuccino.jp/keisuken/logbook/"),
      Map("name"->"kmizu","site"->"http://d.hatena.ne.jp/kmizushima/"),
      Map("name"->"yuroyoro","site"->"http://d.hatena.ne.jp/yuroyoro/")
    )
    templateEngine.layout("/hackers.mustache", Map( "list" -> hackers ))
  }
  
}
