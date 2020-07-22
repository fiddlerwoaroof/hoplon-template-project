(ns ^{:hoplon/page "index.html"} pages.index
  (:require [hoplon.core  :as h :refer [div ul li html link head title body h1 span p button text]]
            [javelin.core :as j :refer [cell cell=]]
            [hoplon.jquery]))

(html
  (head
    (link :href "app.css" :rel "stylesheet" :type "text/css"))
  (body
    (h1 "Hello, Hoplon!")))
