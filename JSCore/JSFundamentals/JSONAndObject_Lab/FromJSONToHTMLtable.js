function jsonToHtmlTable(json) {
  let html = '<table>\n';
  html += ' <tr>';
  const arr = JSON.parse(json);
  const keys = Object.keys(arr[0]);
  for (const key of keys) {
    html += `<th>${htmlEscape(key)}</th>`;
  }
  html += '</tr>\n';

  for (let obj of arr) {
    html += ' <tr>';
    for (const key of keys) {
      html += `<td>${htmlEscape(obj[key])}</td>`;
    }
    html += '</tr>\n';
  }
  html += '</table>';
  return html;

  function htmlEscape(text) {
    return text.toString()
      .replace(/&/g, '&amp;')
      .replace(/</g, '&lt;')
      .replace(/>/g, '&gt;')
      .replace(/"/g, '&quot;')
      .replace(/'/g, '&#39;');
  }
}

console.log(jsonToHtmlTable([
  '[{"Name":"Tomatoes & Chips","Price":2.35},{"Name":"J&B Chocolate","Price":0.96}]',
]));

console.log(jsonToHtmlTable([
  '[' +
  '{"Name":"Pesho <div>-a","Age":20,"City":"Sofia"}, ' +
  '{"Name":"Gosho","Age":18,"City":"Plovdiv"},' +
  '{"Name":"Angel","Age":18,"City":"Veliko Tarnovo"}' +
  ']'
]));