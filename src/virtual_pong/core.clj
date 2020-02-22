(ns virtual-pong.core
  (:gen-class)
  (:import [java.awt.event ActionListener KeyListener KeyEvent])
  (:require [quil.core :as quil])
  (:require [clojure.core.async :as async]))


(defn draw-rect-left [y]
  (quil/rect 0 y 30 120))

(defn draw-rect-right [y]
  (quil/rect 770 y 30 120))

(defn draw-rect-ball [x y]
  (quil/rect x y 35 35 100))

(def player1-coordinates (atom {:y 0}))
(def player2-coordinates (atom {:y 0}))

(def player1-keys-collection (atom []))
(def player2-keys-collection (atom {:right :off}))

(defn move-player1-up []
  (swap! player1-coordinates update-in [:y] - 7))

(defn move-player1-down []
  (swap! player1-coordinates update-in [:y] + 7))

(defn move-player2-up []
  (swap! player2-coordinates update-in [:y] - 7))

(defn move-player2-down []
  (swap! player2-coordinates update-in [:y] + 7))

#_
(defn players-movement [key]
  (cond
    (= key :right) (do
                     (println "Vienas")
                     (swap! player2-keys-collection assoc :right :on)
                     (println @player2-keys-collection)
                     (while (= (get @player2-keys-collection :right) :on) (println "belenkas")))))

(defn players-movement [key]
  (cond
    (= key :right) (do
                     (swap! player2-keys-collection assoc :right :on)
                     (Thread. (while (= (get @player2-keys-collection :right) :on) (println "belenkas"))))))

(defn key-pressed
  "Function is activated when a key is pressed"
  []
  (when (quil/key-pressed?)
    (players-movement (quil/key-as-keyword))))

(defn key-released []
  (do
    (println "Collection contains")
    (println @player2-keys-collection)
    (println (str "Released:" (quil/key-as-keyword)))
    (swap! player2-keys-collection assoc :right :off)
    (println "After release collection contains")
    (println @player2-keys-collection)))

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
                :key-pressed key-pressed
                :key-released key-released)

#_
    (defn key-released
      "Function is activated when a key is released"
      []
      (println (str "Released: " (quil/raw-key))))

#_
    (defn players-movement
      "Checking which key is pressed and calling corresponding function"
      [key]
      (cond
        (= key :right) (move-player2-up)
        (= key :left) (move-player2-down)
        (= key :d) (move-player1-down)
        (= key :a) (move-player1-up)))
  
