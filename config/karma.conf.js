var webpackConfig = require("./webpack.test");

module.exports = function (config) {
    var _config = {
        basePath: "",
        reporters: ['progress', 'html'],
        htmlReporter: {
            outputFile: 'config/units.html',
                  
            // Optional
            pageTitle: 'Unit Tests',
            subPageTitle: 'Sample APP',
            groupSuites: true,
            useCompactStyle: true,
            useLegacyStyle: true
          },

        frameworks: [ "jasmine" ],

        files: [
            {pattern: "./karma-test-shim.js", watched: false}
        ],

        preprocessors: {
            "./karma-test-shim.js": [ "webpack", "sourcemap" ]
        },

        webpack: webpackConfig,

        webpackMiddleware: {
            stats: "errors-only"
        },

        webpackServer: {
            noInfo: true
        },

        reporters: [ "progress" ],
        port: 9876,
        colors: true,
        logLevel: config.LOG_INFO,
        autoWatch: false,
        browsers: [ "Chrome" ],
        singleRun: true
    };

    config.set(_config);
};