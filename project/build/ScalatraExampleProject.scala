import sbt._

class ScalatraExampleProject(info: ProjectInfo) extends AppengineProject(info) with net.stbbs.yasushi.ScalatePlugin
{
  val scalaToolsSnapshots = "Scala Tools Repository" at "http://nexus.scala-tools.org/content/repositories/snapshots/"
  val sonatypeNexusSnapshots = "Sonatype Nexus Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
  val sonatypeNexusReleases = "Sonatype Nexus Releases" at "https://oss.sonatype.org/content/repositories/releases"
  //val fuseSourceSnapshots = "FuseSource Snapshot Repository" at "http://repo.fusesource.com/nexus/content/repositories/snapshots"

  val scalate = "org.fusesource.scalate" % "scalate-core" % "1.2"
  val scalatra = "org.scalatra" %% "scalatra" % "2.0.0-SNAPSHOT"
  val scalatraScalate = "org.scalatra" %% "scalatra-scalate" % "2.0.0-SNAPSHOT"

  val slf4j = "org.slf4j" % "slf4j-jdk14" % "1.6.1"

  override def templateRoots = webappPath / "WEB-INF"
}
