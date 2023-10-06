(ns app.client
  (:require 
    [app.application :refer [app]]
    [app.ui :as ui]
    [com.fulcrologic.fulcro.application :as app]
    [com.fulcrologic.fulcro.components :as comp :refer [defsc]]
    [com.fulcrologic.fulcro.data-fetch :as df]))


(defn ^:export init []
  (app/mount! app ui/Root "app")
  (df/load! app :friends ui/PersonList)
  (df/load! app :enemies ui/PersonList)
  (js/console.log "Loaded"))

(defn ^:export refresh []
  (app/mount! app ui/Root "app")
  (comp/refresh-dynamic-queries! app)
  (js/console.log "Hot reload"))


