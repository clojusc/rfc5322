# rfc5322

[![Build Status][travis-badge]][travis]
[![Dependencies Status][deps-badge]][deps]
[![Clojars Project][clojars-badge]][clojars]
[![Tag][tag-badge]][tag]
[![JDK version][jdk-v]](.travis.yml)
[![Clojure version][clojure-v]](project.clj)

[![][logo]][logo-large]

*A Parser for the Internet Message Format (RFC 5322)*


## Usage

There's a nice little prompt when you start up a REPL:

```bash
$ lein repl
```

```clj

To demo the code, try the following:

	(demo-lite)
	(source demo-lite)
	(source parsed-lite)
	parsed-lite

	(demo-full)
	(source demo-full)
	(source parsed-full)
	parsed-full

	(test-message)

...

[rfc5322.repl] λ=>
```

Try those out, then look at the source code in the following
locations:

* `dev-resources/src/rfc5322/repl.clj`
* `src/rfc5322/core.clj`
* `src/rfc5322/parser.clj`
* `src/rfc5322/xform.clj`

The test message used in `repl.clj` is here:

* `test/rfc5322/core/test.clj`


## License

Copyright © 2013, Zachary Kuhn

Copyright © 2017-2019, Clojure-Aided Enrichment Center

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.


<!-- Named page links below: /-->

[travis]: https://travis-ci.org/clojusc/rfc5322
[travis-badge]: https://travis-ci.org/clojusc/rfc5322.png?branch=master
[deps]: http://jarkeeper.com/clojusc/rfc5322
[deps-badge]: http://jarkeeper.com/clojusc/rfc5322/status.svg
[logo]: resources/images/logo.png
[logo-large]: resources/images/logo-large.png
[tag-badge]: https://img.shields.io/github/tag/clojusc/rfc5322.svg
[tag]: https://github.com/clojusc/rfc5322/tags
[clojure-v]: https://img.shields.io/badge/clojure-1.10.0-blue.svg
[jdk-v]: https://img.shields.io/badge/jdk-1.8+-blue.svg
[clojars]: https://clojars.org/clojusc/rfc5322
[clojars-badge]: https://img.shields.io/clojars/v/clojusc/rfc5322.svg
