(ns ^{:hoplon/page "index.html"}
    pages.index
  (:require [hoplon.core  :as h :refer [div ul li html link head title body h1 span p button text]]
            [javelin.core :as j :refer [cell cell=]]
            [hoplon.jquery]))

(defn my-list [& items]
  (div
   :class "my-list"
   (apply ul (map #(li (div :class "my-list-item" %)) items))))

(def clicks (cell 0))
(def cell1 (cell 2))

(html
 (head
  (title "example page"))
 (body
  (h1 "Hello, Hoplon")

  (my-list
   (span "first thing")
   (span "second thing"))

  (p (text "You've clicked ~{clicks} ~{cell1} ... times, so far."))
  (button :click #(swap! clicks inc) "click me")))
