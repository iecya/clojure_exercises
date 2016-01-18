(ns clojure-noob.core
  (:gen-class))


;(def mydata (atom {:height 200 :weight 80}))
;
;(defn calc-bmi []
;  ;;creo l'oggetto 'data' (assegnandogli height, width e bmi come chiavi) uguale a @mydata
;  (let [{:keys [height weight bmi] :as data} @mydata
;        ;;il simbolo h rappresenta il valore di height diviso 100
;        h (/ height 100)]
;
;    ;;controllo se bmi = nil
;    (if (nil? bmi)
;      ;;se bmi = nil gli assegno il valore e return data
;      (assoc data :bmi (/ weight (* h h)))
;
;      ;;se bmi not= nil assegno un valore a weight e return data
;      (assoc data :weight (* bmi h h 2)))))
;
;(defn inputs [param value]
;  [:input {:type "text"
;           :value value
;           :onchange (fn [e]
;                       ;;on change event update param (height, weight or bmi) value to the one set into the input (.-target.value e)
;                       (swap! mydata assoc param (.-target.value e))
;                       ;;if param is NOT bmi, swap bmi value to nil
;                       (when (not= param :bmi)
;                         (swap! mydata assoc :bmi nil)))}])





(defn error-message
  [severity]
  (str "OH GOD! IT'S A DISASTER! WE'RE "
       (if (= severity :mild)
         "MILDLY INCONVENIENCED!"
         "DOOOOOOOMED!")))



(defn -main
  "I don't do a whole lot.. yet!"
  [& args]
  ;(if true
  ;  ;;value returned if true
  ;  (println "1.1 By Zeus' hammer!")
  ;  ;;value returne if false
  ;  (println "1.1 By Aquaman's trident!"))
  ;(if false
  ;  ;;value returned if true
  ;  (println "1.2 By Zeus' hammer!")
  ;  ;;value returned if false
  ;  (println "1.2 By Aquaman's trident!"))
  ;
  ;;;omitting the 'else' branch (false form) it will return nil if the evaluation is false
  ;(if false
  ;  (println "2.1 By Odin's elbow!"))
  ;
  ;(if true
  ;  ;;'do' allows to run multiple functions in the true/false forms
  ;  ;;all the functions run in the true form
  ;  (do (println "3.1 Success!")
  ;      "By Zeus' hammer!")
  ;  ;;all the functions run in the false form
  ;  (do (println "3.1 Fail")
  ;      "By Aquaman's trident"))
  ;(if false
  ;  ;;'do' allows to run multiple functions in the true/false forms
  ;  ;;all the functions run in the true form
  ;  (do (println "3.2 Success!")
  ;      "By Zeus' hammer!")
  ;  ;;all the functions run in the false form
  ;  (do (println "3.2 Fail")
  ;      "By Aquaman's trident"))
  ;
  ;(when true
  ;  (println "4.1 Success!")
  ;  "abra cadabra")
  ;
  ;(nil? 1)
  ;; => false
  ;
  ;(nil? nil)
  ;;=> true
  ;
  ;(if "bears eat beets"
  ;  "bears beets Battlestar Galactica")
  ;; => "bears beets Battlestar Galactica"
  ;
  ;(if nil
  ;  "This won't be the result because nil is falsey"
  ;  "nil is falsey")
  ;; => "nil is falsey"
  ;
  ;
  ;
  ;;or returns either the first truthy value or the last value.
  ;(or false nil :large_I_mean_venti :why_cant_I_just_say_large)
  ;; => :large_I_mean_venti
  ;
  ;(or (= 0 1) (= "yes" "no"))
  ;; => false
  ;
  ;(or nil)
  ;; => nil
  ;
  ;
  ;
  ;;and returns the first falsey value or, if no values are falsey, the last truthy value.
  ;(and :free_wifi :hot_coffee)
  ;; => :hot_coffee
  ;
  ;(and :feelin_super_cool nil false)
  ;; => nil



  (println (error-message :mild))
  (println (error-message :doom)))




















; **FUNZIONE CHE PERMETTE DI PASSARE UNA FUNZIONE A TUTTI GLI ELEMENTI DI UNA MAPPA**
;(defn update-values [m f & args]
;  (reduce
;    ;;r = {} il primo parametro passato alla fine della funzione, una mappa in cui inserire le key di quella precedente con i nuovi valori
;    ;;[k v] e' la key (con value associato) preso in considerazione da reduce (reduce sulle mappe considera come item l'insieme di key e valore associato)
;    (fn [r [k v]]
;      ;;associa alla key K della mappa R un nuovo valore
;      (assoc r k
;               ;;applica la funzione f (passata come parametro alla funzione madre) a v e tutti gli args passati
;               (apply f v args))) {} m))

