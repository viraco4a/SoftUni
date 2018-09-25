function multiplicationTable(n){
    console.log('<table border="1">');
    let order = '<tr>';
    for (let i = 0; i <= n; i++) {
        order += '<th>';
        if (i == 0){
            order += 'x';
        } else {
            order += i;
        }
        order += `</th>`;
    }
    order += `</tr>`;
    console.log(order);
    for (let i = 1; i <= n; i++) {
        let order = '<tr>';
        for (let j = 0; j <= n; j++) {
            if (j == 0){
                order += '<th>';
            } else {
                order += '<td>';
            }
            if (j == 0){
                order += i;
            } else {
                order += i * j;
            }
            if (j == 0){
                order += '</th>';
            } else {
                order += '</td>';
            }
        }
        order += `</tr>`;
        console.log(order);
    }
    console.log('</table>');
}

multiplicationTable(5)