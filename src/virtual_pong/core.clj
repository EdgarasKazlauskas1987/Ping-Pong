(ns virtual-pong.core
  (:gen-class)
  (:import [java.awt.event KeyEvent])
  (:require [quil.core :as quil]))


(defn draw-rect-left [y]
  (quil/rect 0 y 30 120))

(defn draw-rect-right [y]
  (quil/rect 770 y 30 120))

(defn draw-rect-ball [x y]
  (quil/rect x y 35 35 100))

(def player1-coordinates (atom {:y 0}))
(def player2-coordinates (atom {:y 0}))

(defn move-player1-up []
  (swap! player1-coordinates update-in [:y] - 7))

(defn move-player1-down []
  (swap! player1-coordinates update-in [:y] + 7))

(defn move-player2-up []
  (swap! player2-coordinates update-in [:y] - 7))

(defn move-player2-down []
  (swap! player2-coordinates update-in [:y] + 7))

(defn players-movement
  "Checking which key is pressed and calling corresponding function"
  [key]
  (cond
    (= key :right) (move-player2-up)
    (= key :left) (move-player2-down)
    (= key :d) (move-player1-down)
    (= key :a) (move-player1-up)))

(defn key-pressed
  "Function is activated when a key is pressed"
  []
  (when (quil/key-pressed?)
    (players-movement (quil/key-as-keyword))))

(defn draw []
  (quil/background 11)
  (draw-rect-left (get @player1-coordinates :y))
  (draw-rect-right (get @player2-coordinates :y))
  (draw-rect-ball 100 100))

(quil/defsketch pong
                :title "Virtual Pong"
                :size [800 450]
                :setup (fn [] (quil/smooth) (quil/no-stroke) (quil/frame-rate 60))
                :draw (fn [] (draw))
                :key-pressed key-pressed)
  
