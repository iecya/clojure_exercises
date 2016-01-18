(ns clojure-noob.hobbit)


(def asym-hobbit-body-parts [{:name "head" :size 3}
                             {:name "left-eye" :size 1}
                             {:name "left-ear" :size 1}
                             {:name "mouth" :size 1}
                             {:name "nose" :size 1}
                             {:name "neck" :size 2}
                             {:name "left-shoulder" :size 3}
                             {:name "left-upper-arm" :size 3}
                             {:name "chest" :size 10}
                             {:name "back" :size 10}
                             {:name "left-forearm" :size 3}
                             {:name "abdomen" :size 6}
                             {:name "left-kidney" :size 1}
                             {:name "left-hand" :size 2}
                             {:name "left-knee" :size 2}
                             {:name "left-thigh" :size 4}
                             {:name "left-lower-leg" :size 3}
                             {:name "left-achilles" :size 1}
                             {:name "left-foot" :size 2}])

(defn matching-part
      ;;part e' una mappa che contiene le keys :name e :size (come nella data structure definita sopra, di cui 'part' fa parte)
      [part]

      ;;alla key :name viene associato il valore restituito dalla funzione 'string/replace', la quale prende la regex (#"^left-") e assegna il nuovo valore ("right-")
      {:name (clojure.string/replace (:name part) #"^left-" "right-")

       ;;alla key :size viene assegnato lo stesso valore che ha la key :size nella mappa part
       :size (:size part)})


(defn symmetrize-body-parts
      "Expects a seq of maps that have a :name and :size"
      [asym-body-parts]

      ;remaining-asym-parts = asym-body-parts (every time it loops asym-body-parts will have one less element resolved into matching-part function and pushed into final-body-parts vector
      ;final-body-parts starts as empty vector and will grow everytime a hobbit's body part will be resolved into matching-part function and pushed into it
      (loop [remaining-asym-parts asym-body-parts
             final-body-parts []]
            (if (empty? remaining-asym-parts)
              final-body-parts

              ;part = remaining-asym-parts' first element. remaining = all other remaining-asym-parts' elements
              (let [[part & remaining] remaining-asym-parts]
                   (recur remaining

                          ;push into final-body-parts
                          (into final-body-parts

                                ;make a set of part and its matching part
                                (set [part (matching-part part)])))))))


; SYMMETRIZE-BODY-PART (spiegazione)
;la funzione loop assegna al simbolo "remaining-asym-parts" il valore di asym-body-parts (il valore iniziale sara' uguale all'intera sequenza di parti) ed a "final-body-parts" un vector vuoto.
;QUindi controlla se remaining-asyn-parts e' vuoto (se ha finito il loop): se si, ritorna final-body-parts.
;Se no, usa la funzioen let: part sara' uguale al primo elemento della sequenza "remaining-asym-part" e remaining saranno tutti gli altri elementi.
;Quindi usa recur sugli elementi restanti (da rivedere la funzione recur).
;
;Per la parte finale e' meglio valutarla dall'ultima funzione che viene chiamata andando poi a ritroso:
;Matching-part prende la parte che viene valutata al momento (il primo elemento sara' {:head "head" :size 3}) e, se e' una parte laterale (braccio, occhio etc etc) ritorna l'equivalente opposto (il destro). Controllare la spiegazione all'interno della funzione.
;Quindi crea un set con part e il valore tornato da matching part. In questo modo se part non ha una matching part (come la head) non si creano doppioni.
;Il tutto viene pushato nel vector "final-body-parts".abort
;
;La funzione recur (da ricontrollare, questa spiegazione e' approssimativa) prosegue il loop sugli elementi rimanenti della sequenza "asym-body-parts". Quindi la sequenza iniziale sara' uguale al vector passato con tutte le parti del corpo, dopo che la head e' stata valutata il loop prosegue su tutte le altre parti e cosi via






(symmetrize-body-parts asym-hobbit-body-parts)