(set-env!
  :dependencies '[[adzerk/boot-cljs          "2.1.5"]
                  [adzerk/boot-reload        "0.6.0"]
                  [hoplon/hoplon             "7.2.0"]
                  [org.clojure/clojure       "1.10.1"]
                  [org.clojure/clojurescript "1.10.773"]
                  [tailrecursion/boot-jetty  "0.1.3"]
                  [jakarta.xml.bind/jakarta.xml.bind-api "2.3.3"]]
  :source-paths #{"src"}
  :asset-paths  #{"assets"})

(require
  '[adzerk.boot-cljs         :refer [cljs]]
  '[adzerk.boot-reload       :refer [reload]]
  '[hoplon.boot-hoplon       :refer [hoplon prerender]]
  '[tailrecursion.boot-jetty :refer [serve]])

(deftask dev
  "Build hoplon-try-again for local development."
  []
  (comp
    (watch)
    (speak)
    (hoplon)
    (reload)
    (cljs)
    (serve :port 8000)))

(deftask prod
  "Build hoplon-try-again for production deployment."
  []
  (comp
    (hoplon)
    (cljs :optimizations :advanced)
    (target :dir #{"target"})))
