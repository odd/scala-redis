import sbt._

class Plugins(info: ProjectInfo) extends PluginDefinition(info) {

  // ---------------------------------------------------------------
  // All repositories *must* go here! See ModuleConigurations below.
  // ---------------------------------------------------------------
  object Repositories {
    lazy val EmbeddedRepo = "Embedded Repo" at (info.projectPath / "embedded-repo").asURL.toString
  }

  // -------------------------------------------------------------------------------------------------------------------
  // ModuleConfigurations
  // Every dependency that cannot be resolved from the built-in repositories (Maven Central and Scala Tools Releases)
  // must be resolved from a ModuleConfiguration. This will result in a significant acceleration of the update action.
  // Therefore, if repositories are defined, this must happen as def, not as val.
  // -------------------------------------------------------------------------------------------------------------------
  import Repositories._
  lazy val ideaModuleConfig = ModuleConfiguration("com.github.mpeltonen", EmbeddedRepo)

  // ------------
  // Dependencies
  // ------------
  lazy val idea = "com.github.mpeltonen" % "sbt-idea-plugin" % "0.1-SNAPSHOT"
}