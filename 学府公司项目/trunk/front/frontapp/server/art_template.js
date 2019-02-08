var template = require('art-template');


function renderFile(filename, options, callback) {

    var data = options;

    if (options.settings && options.settings['view options']) {
        options = options.settings['view options'];
    }

    options.filename = filename;

    try {
        var render = template.compile(options);
        callback(null, render(data));
    } catch (e) {
        callback(e);
    }
}

template.defaults.rules.unshift({ test: /<script type=("|')text\/html("|')[^>]*>([\w\W]*?)<\/script>/, use: function (match) { return { output: 'raw', code: JSON.stringify(match + '') } } });
renderFile.template = template;
module.exports = renderFile;