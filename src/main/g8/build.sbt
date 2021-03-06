import Dependencies._
import Settings._

lazy val $module1$ = (project in file("$module1$"))
  .settings(Settings.settings: _*)
  .settings(Settings.$module1$Settings: _*)
  .settings(libraryDependencies ++= $module1$Dependencies.toSeq)

lazy val $module2$ = (project in file("$module2$"))
  .settings(Settings.settings: _*)
  .settings(Settings.$module2$Settings: _*)
  .settings(libraryDependencies ++= $module2$Dependencies.toSeq)

lazy val $appname$ = (project in file("$appname$"))
  .settings(Settings.settings: _*)
  .settings(Settings.$appname$Settings: _*)
  .dependsOn(
    $module1$,
    $module2$,
  )
  .configs(Test)

lazy val root = (project in file("."))
  .aggregate(
    $module1$,
    $module2$,

    $appname$,
  )
  .settings(libraryDependencies ++= rootDependencies.toSeq)
