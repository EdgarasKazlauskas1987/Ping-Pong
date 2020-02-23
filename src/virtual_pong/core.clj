(ns virtual-pong.core
  (:gen-class)
  (:import (javax.swing JPanel JFrame JLabel)
           (java.awt BorderLayout Dimension FlowLayout)))

(def paddle        (JLabel.))
(doto paddle       (.setSize (Dimension. 50 50)))

(def  pane1       (JPanel. (FlowLayout.)))
(doto pane1       (.add paddle))

(def  frame       (JFrame. "Ping Pong"))
(doto frame       (.setSize (Dimension. 870 500))
                  (.add BorderLayout/SOUTH pane1)
                  (.setVisible true))

  
