import sbt._
import Keys._

object BuildSettings {
  val javaVersion = sys.props("java.specification.version")

  assert(javaVersion == "1.8" || javaVersion == "1.7",
    f"ScalaFX supports Java versions 1.7 and higher.  Current version is (${javaVersion}).  Please upgrade the version of your Java Development Kit")

  // ScalaFX の設定．Java 8 に依存するため注意を要する
  val scalafxSettings =
    if (javaVersion == "1.8")      // Java 8 用の設定
      Seq(libraryDependencies += "org.scalafx" %% "scalafx" % "8.0.60-R9")
    else                           // Java 7 用の設定
      Seq(libraryDependencies += "org.scalafx" %% "scalafx" % "2.2.76-R11",
        unmanagedJars in Compile += Attributed.blank(file(scala.util.Properties.javaHome) / "/lib/jfxrt.jar"))
  val buildSettings = Defaults.defaultSettings ++ scalafxSettings
}

object MyBuild extends Build {
  import BuildSettings._
  lazy val root: Project = Project("root", file("."), settings = buildSettings)
}
