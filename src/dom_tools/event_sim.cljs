(ns dom-tools.event-sim
  (:require [dom-tools.query]
            [dom-tools.test-utils :as tu]))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; React event simulation wrappers
;
; TODO:
; Test all of these events against a single component (i.e. a div) with a single
; ":on[Event]" handler function attached to all of the events that does something very simple, like
; changing an ":[event]ChangeSuccess" boolean from false to true.
;
; TODO:
; Check existing libraries for a way to create event data.



(defn blur [x & {:keys [] :as evt-data}] (js/React.addons.TestUtils.Simulate.blur x (clj->js evt-data)))
(defn click [x & {:keys [] :as evt-data}] (js/React.addons.TestUtils.Simulate.click x (tu/hashmap-to-js-obj evt-data)))
(defn contextMenu [x & {:keys [] :as evt-data}] (js/React.addons.TestUtils.Simulate.contextMenu x evt-data))
(defn copy [x & {:keys [] :as evt-data}] (js/React.addons.TestUtils.Simulate.copy x evt-data))
(defn cut [x & {:keys [] :as evt-data}] (js/React.addons.TestUtils.Simulate.cut x evt-data))
(defn doubleClick [x & {:keys [] :as evt-data}] (js/React.addons.TestUtils.Simulate.doubleClick x evt-data))
(defn drag [x & {:keys [] :as evt-data}] (js/React.addons.TestUtils.Simulate.drag x evt-data))
(defn dragEnd [x & {:keys [] :as evt-data}] (js/React.addons.TestUtils.Simulate.dragEnd x evt-data))
(defn dragEnter [x & {:keys [] :as evt-data}] (js/React.addons.TestUtils.Simulate.dragEnter x evt-data))
(defn dragExit [x & {:keys [] :as evt-data}] (js/React.addons.TestUtils.Simulate.dragExit x evt-data))
(defn dragLeave [x & {:keys [] :as evt-data}] (js/React.addons.TestUtils.Simulate.dragLeave x evt-data))
(defn dragOver [x & {:keys [] :as evt-data}] (js/React.addons.TestUtils.Simulate.dragOver x evt-data))
(defn dragStart [x & {:keys [] :as evt-data}] (js/React.addons.TestUtils.Simulate.dragStart x evt-data))
(defn simulate-drop [x & {:keys [] :as evt-data}] (js/React.addons.TestUtils.Simulate.drop x evt-data))
(defn focus [x & {:keys [] :as evt-data}] (js/React.addons.TestUtils.Simulate.focus x evt-data))
(defn input [x & {:keys [] :as evt-data}] (js/React.addons.TestUtils.Simulate.input x evt-data))
(defn keyDown [x & {:keys [] :as evt-data}] (js/React.addons.TestUtils.Simulate.keyDown x evt-data))
(defn keyPress [x & {:keys [] :as evt-data}] (js/React.addons.TestUtils.Simulate.keyPress x evt-data))
(defn keyUp [x & {:keys [] :as evt-data}] (js/React.addons.TestUtils.Simulate.keyUp x evt-data))
(defn load [x & {:keys [] :as evt-data}] (js/React.addons.TestUtils.Simulate.load x evt-data))
(defn error [x & {:keys [] :as evt-data}] (js/React.addons.TestUtils.Simulate.error x evt-data))
(defn mouseDown [x & {:keys [] :as evt-data}] (js/React.addons.TestUtils.Simulate.mouseDown x evt-data))
(defn mouseMove [x & {:keys [] :as evt-data}] (js/React.addons.TestUtils.Simulate.mouseMove x evt-data))
(defn mouseOut [x & {:keys [] :as evt-data}] (js/React.addons.TestUtils.Simulate.mouseOut x evt-data))
(defn mouseOver [x & {:keys [] :as evt-data}] (js/React.addons.TestUtils.Simulate.mouseOver x evt-data))
(defn mouseUp [x & {:keys [] :as evt-data}] (js/React.addons.TestUtils.Simulate.mouseUp x evt-data))
(defn paste [x & {:keys [] :as evt-data}] (js/React.addons.TestUtils.Simulate.paste x evt-data))
(defn reset [x & {:keys [] :as evt-data}] (js/React.addons.TestUtils.Simulate.reset x evt-data))
(defn scroll [x & {:keys [] :as evt-data}] (js/React.addons.TestUtils.Simulate.scroll x evt-data))
(defn submit [x & {:keys [] :as evt-data}] (js/React.addons.TestUtils.Simulate.submit x evt-data))
(defn touchCancel [x & {:keys [] :as evt-data}] (js/React.addons.TestUtils.Simulate.touchCancel x evt-data))
(defn touchEnd [x & {:keys [] :as evt-data}] (js/React.addons.TestUtils.Simulate.touchEnd x evt-data))
(defn touchMove [x & {:keys [] :as evt-data}] (js/React.addons.TestUtils.Simulate.touchMove x evt-data))
(defn touchStart [x & {:keys [] :as evt-data}] (js/React.addons.TestUtils.Simulate.touchStart x evt-data))
(defn wheel [x & {:keys [] :as evt-data}] (js/React.addons.TestUtils.Simulate.wheel x evt-data))
(defn mouseEnter [x & {:keys [] :as evt-data}] (js/React.addons.TestUtils.Simulate.mouseEnter x evt-data))
(defn mouseLeave [x & {:keys [] :as evt-data}] (js/React.addons.TestUtils.Simulate.mouseLeave x evt-data))
(defn change [x & {:keys [] :as evt-data}] (js/React.addons.TestUtils.Simulate.change x evt-data))
(defn compositionEnd [x & {:keys [] :as evt-data}] (js/React.addons.TestUtils.Simulate.compositionEnd x evt-data))
(defn compositionStart [x & {:keys [] :as evt-data}] (js/React.addons.TestUtils.Simulate.compositionStart x evt-data))
(defn compositionUpdate [x & {:keys [] :as evt-data}] (js/React.addons.TestUtils.Simulate.compositionUpdate x evt-data))
(defn select [x & {:keys [] :as evt-data}] (js/React.addons.TestUtils.Simulate.select x evt-data))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Custom event simulations
;
; TODO:
; Provide some more powerful meta-functions
;
; Start with these three:
; (click elem & :keys :vals)
; (click elem :x 1 :y 2)
; (send-keys elem "asdf" & more?)
; (dbl-click elem ...)
;
;
; Examples of usage:
;
;(click-button :label "Today" component)
;(click-button :key "1" component)
;(click-button "key" "whatever" component)
;(click-button :class-name "" component)
;(click-checkbox :data-boo "blah" component)
;(send-input  )
;(send-keys  )


