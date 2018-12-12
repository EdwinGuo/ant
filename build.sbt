
name := "ant"
version := "1.0"
scalaVersion := "2.11.14"

val sparkVersion = "2.3.0"

dependencyOverrides += "com.fasterxml.jackson.core"   % "jackson-core"              % "2.8.9"
dependencyOverrides += "com.fasterxml.jackson.core"   % "jackson-databind"          % "2.8.9"
dependencyOverrides += "com.fasterxml.jackson.module" % "jackson-module-scala_2.11" % "2.8.9"

libraryDependencies ++= Seq(
        "org.apache.spark"            %% "spark-core"              % sparkVersion   % "provided",
        "org.apache.spark"            %% "spark-sql"               % sparkVersion   % "provided",
        "org.scala-lang"              %  "scala-reflect"           % "2.11.11",
        "com.opencsv"                 %  "opencsv"                 % "4.0",
        "com.hortonworks.registries"  %  "schema-registry-client"  % "0.3.0"     exclude ("org.slf4j", "log4j-over-slf4j"),
        "org.apache.avro"             %  "avro"                    % "1.8.2",
        "com.github.scopt"            %% "scopt"                   % "3.6.0",
        "org.scalatest"               %  "scalatest_2.11"          % "3.0.3"       % "test",
        "org.mockito"                 % "mockito-core"             % "2.8.9"       % "test",
        "com.holdenkarau"             %% "spark-testing-base"      % "2.2.0_0.8.0" % "test",
        "org.apache.spark"            %% "spark-hive"              % "2.2.0"       % "test",
        "joda-time"                   %  "joda-time"               % "2.9.9",
        )

mainClass in assembly := Some("Driver.MainApp")

assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false)

    assemblyJarName in assembly := s"${name.value}_${scalaBinaryVersion.value}-${version.value}.jar"

    assemblyMergeStrategy in assembly := {
        case PathList("META-INF", xs @ _*) => MergeStrategy.discard
            case x => MergeStrategy.first
    }
