(ns app.scratch
  (:require
   [app.application :as application]
   [app.ui :as ui :refer [Person PersonList Root]]
   [com.fulcrologic.fulcro.algorithms.denormalize :as fdn]
   [com.fulcrologic.fulcro.application :as app]
   [com.fulcrologic.fulcro.components :as comp]
   [com.fulcrologic.fulcro.data-fetch :as df]
   [com.fulcrologic.fulcro.algorithms.data-targeting :as targeting]))

(def foo 
  {:foo/bar 1 :foo/baz "two"})

(let [{:foo/keys [bar baz]} foo]
  (str bar " " baz))

(comment
  (def state (app/current-state application/app))
  (def query (comp/get-query Root))
  (fdn/db->tree query state state)
  (meta (comp/get-query PersonList))
  (df/load! application/app [:person/id 3] Person {:target (targeting/append-to [:list/id :friends :list/people])})
  ,)
