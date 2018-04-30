# Release v18.5.1

* NEW: log when pong is received (#400)
* NEW: AndroidWebSocket: Allow to disable heartbeat (#399)
* NEW: Allow to update auto ping variables on a connected session (#394)

---

# Release v18.3.2

* FIX: Fire onLeave() when session is lost (#390)
* NEW: extend Client class to (optionally) take TransportOptions (#386)
* NEW: Extend WAMP transports to be configurable (#385)

---

# Release v18.3.1

* FIX: Expand README with more installation instructions, build hints and code/usage idioms (#387, #377, #370)
* NEW: Allow setting the TLS version used with WebSocket (Netty) (#376)
* FIX: WAMP request IDs are long, not int - _always_ (#366)
* FIX: Add CI tests for all 4 basic WAMP actions (#373)
* FIX: Actually break the CI ("red flag") on all run-time errors (#372)
* NEW: More POJO examples (#368)
* FIX: WAMP call message parsing corner case (#367)
* NEW: Alternative high-level WAMP API ("reflection based roles") (#380)
* NEW: Example for WAMP authentication (#361)
* NEW: WAMP unregister/unsubscribe (#353)
* NEW: WAMP-Cryptosign (Ed25519) authentication (#347)
* NEW: WAMP-Ticket authentication (#344)
* FIX: legacy Android build (#336)

---

# Release v17.10.5

* Enable exceptions in user code to include error details (#327)
* Extend POJO APIs for call/subscribe to accept class references (#326)
* Simplify examples and remove redundant code (#325)
* Cleanup Session class (#324)
* WAMP: Allow Session.register() endpoints to return POJOs (#323)
* WAMP: Session.subscribe() POJOs support (#320)
* Update README with simple examples (#319)
* Extend legacy android support (incubating) (#315)
* Correctly use gradle deps API so that clients download deps automatically (#314)
* make: dynamically disable debug logging before releasing (#313)

---

# Release v17.10.4

* Session API convenience and cleanup (#312)
* Rename NettyTransport to NettyWebSocket (#310)
* Revamp logging (#309)
* Android: Execute callbacks on main(UI) thread (#307)
* Simplify the Client API (#306)
* Fix WebSocket auto-reconnect (#305)

---

# Release v17.10.3

* Fix android package to not conflict with main app's label (#299)

---

# Release v17.10.1

* Add change log generator (#294)
* Maven and JCenter config (#293)
* add script to support older versions of android (#291)
* Expose API for WS pings/pongs and implement auto keepalive (#287)
* Reduce java8 usage internally (#285)
* Make example client universal (#283)
* Refactor WebSocket impl (#281)
* Autobahn WAMP transport (#277)
* Complete event retention support and add Event.topic property (#275)

---
