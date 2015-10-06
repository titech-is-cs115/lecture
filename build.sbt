// 重要な注意：各設定の間に必ず空行を挿入して下さい。これをしないと sbt が起動しません。

name := "cs1-lx00a"      // プロジェクトの名称

version := "0.1.0"       // プロジェクトのバージョン番号

scalaVersion := "2.11.7" // コンパイルに使う scalac のバージョン

scalacOptions ++=        // scalac に与えるオプション
  Seq("-optimize",
    "-feature",
    "-unchecked",
    "-deprecation")

javaOptions in run ++=   // 仮想機械に与えるオプション
  Seq( "-Xmx2G", "-verbose:gc")                          

libraryDependencies +=   // プロジェクトで使う非標準 Scala ライブラリ
  "net.liftweb" % "lift-json_2.11" % "3.0-M6"

// sbt の挙動の設定

fork := true

connectInput := true

// ソースコードの在処を非標準の場所に設定

scalaSource in Compile := baseDirectory.value / "src"

scalaSource in Test := baseDirectory.value / "test"

// コンパイル結果を非標準の場所に設定

target := Path.userHome / "tmp" / "cs1f"
