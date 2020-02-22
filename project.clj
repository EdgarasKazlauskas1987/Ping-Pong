(defproject virtual-pong "0.0.1-SNAPSHOT"
  :description "FIXME: write description"
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/core.async "1.0.567"]
                 [quil "3.1.0"]]
  :aot [virtual-pong.core]
  :main virtual-pong.core)
