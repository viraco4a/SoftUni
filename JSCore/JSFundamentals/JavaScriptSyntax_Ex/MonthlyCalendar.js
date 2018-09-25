function montlyCalendar([d,m,y]) {
    [d,m,y] = [d,m,y].map(Number);

    let givenMonth = new Date(y,m,0);
    let givenDayIndex = new Date(y,m-1,1).getDay(); // Sun -> idx = 0

    let prevMonth = (m == 1) ? new Date(y-1,12,0) : new Date(y, m-1,0);
    let html = '<table>\n'
    html += '\t<tr><th>Sun</th><th>Mon</th><th>Tue</th><th>Wed</th><th>Thu</th><th>Fri</th><th>Sat</th></tr>\n';

    for (let calendarRow = 1, idx = 1, next = 1; calendarRow <= 6 && idx <= givenMonth.getDate(); calendarRow++) {
        html += "\t<tr>";
        for (let j = 1; j <= 7; j++) {
            // draw previous
            if (j <= givenDayIndex && calendarRow == 1){
                html += `<td class="prev-month">${(prevMonth.getDate() - givenDayIndex + j)}</td>`;
            // current month
            } else if(idx <= givenMonth.getDate()){
                html += (idx == d) ? `<td class="today">${idx}</td>` : `<td>${idx}</td>`;
                idx++;
            // next month
            } else {
                html += `<td class="next-month">${next}</td>`
                next++;
            }
        }
        html += "</tr>\n";
    }

    html += "</table>";

    return html;
}

montlyCalendar([24, 12, 2012])