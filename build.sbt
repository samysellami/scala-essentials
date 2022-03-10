ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.1.1"

lazy val root = (project in file("."))
    .settings(
      name := "scala-essentials"
    )

// set the main class for 'sbt run'
// mainClass in (Compile, run) := Some("lectures.part1basics.ValuesVariablesTypes")
