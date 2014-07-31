(ns csjspg.core (:require [clojure.java.jdbc :as jdbc] [clojure.java.io :as io] [hiccup.core :as hiccup] [hiccup.page :as hp] [ring.util.servlet :as rs] [ring.adapter.jetty :as rj] [compojure.route :as cr] [compojure.core :as cc :refer [ANY GET POST PUT defroutes let-routes routes]]))

(defroutes base (ANY "/some/:thing" [thing] {:headers {"Content-Type" "text/html"} :response 200 :body (hp/html5 [:html [:head [:title "Well, isn't this something?"]] [:body [:h2 "Welcome to " thing]]])})
                (ANY "*" [request] {:response 501 :headers {"Content-Type" "text/plain"} :body (str "Sorry, we don't have an API for that REST request implemented.  Here's your request map:\n\n" (pr-str request))}))
