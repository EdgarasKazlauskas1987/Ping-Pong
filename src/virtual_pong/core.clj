(ns virtual-pong.core
  (:gen-class)
  (:require [quil.core :as quil]))


(defn draw-rect-left [x y]
  (quil/rect x y 30 120))

(defn draw-rect-right [x y]
  (quil/rect x y 30 120))

(defn draw-rect-ball [x y]
  (quil/rect x y 35 35 100))

(defn players-movement
  "Checking which key is pressed and calling corresponding function"
  [key]
  (cond
    (= key :right) (println "Player A pressed :right key")
    (= key :left) (println "Player A pressed :left key")
    (= key :d) (println "Player B pressed :d key")
    (= key :a) (println "Player B pressed :a key")))

(defn key-pressed
  "Function is activated when a key is pressed"
  []
(when(quil/key-pressed?)
  (players-movement(quil/key-as-keyword))))

(defn draw []
  (quil/background 11)
  (draw-rect-left 0 0)
  (draw-rect-right 770 0)
  (draw-rect-ball 100 100))

(quil/defsketch pong
  :title "Virtual Pong"
  :size [800 450]
  :draw (fn [] (draw))
  :key-pressed key-pressed)
  
