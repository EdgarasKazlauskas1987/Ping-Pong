(ns virtual-pong.core
  (:gen-class)
  (:require [quil.core :as q])
  (:import [java.awt.event KeyEvent]))


(defn draw-rect-left [x y width height]
  (q/rect x y width height))

(defn draw-rect-right [x y width height]
  (q/rect x y width height))

(defn draw-rect-ball [x y]
  (q/rect x y 35 35 100))

(defn key-pressed [])
  ;; Use Cond to check which key is pressed)

(defn draw []
  (q/background 11)
  (draw-rect-left 0 0 30 120)
  (draw-rect-right 770 0 30 120)
  (draw-rect-ball 100 100))

(q/defsketch pong
  :title "Virtual Pong"
  :size [800 450]
  :draw (fn [] (draw)))
  
