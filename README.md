
# Android Project 5 - BitFit Part 1

Submitted by: **Albi Zhaku**

**BitFit** is an Android health tracking app that allows users to log their food consumption and calorie intake. Users can add new foods, track calories, and view their food history in a scrollable list. The app uses Room to store entries locally, allowing users to access their data offline and retain their entries after restarting the application.

Time spent: **3** hours spent in total

## Required Features

The following **required** functionality is implemented:

- [x] **At least one health metric is tracked (based on user input)**
  - Chosen metric(s): `Nutrition / Calories`
- [x] **There is a "create entry" UI that prompts users to make their daily entry**
- [x] **New entries are saved in a database and then updated in the RecyclerView**
- [x] **On application restart, previously entered entries are preserved (i.e., are persistent)**

The following **optional** features are implemented:

- [ ] **Create a UI for tracking averages and trends in metrics**
- [ ] **Improve and customize the user interface through styling and coloring**
- [ ] **Implement orientation responsivity**
- [ ] **Add a daily photo feature**

The following **additional** features are implemented:

- [x] Input validation for food names and calorie values
- [x] Offline storage using Room and SQLite
- [x] Automatic RecyclerView updates using Kotlin Flow
- [x] Display food names alongside their calorie counts

## Video Walkthrough

Here's a walkthrough of implemented user stories: <br/>
<img width="278" height="496" alt="ezgif-6f50276dc23382f5" src="https://github.com/user-attachments/assets/e58f92e9-18a6-4ce1-9046-cddf76264eaa" />


GIF created with ScreenToGif.

## Notes

One challenge I encountered while building BitFit was implementing the Room database and connecting it to the RecyclerView. I learned how to create entities, DAOs, and a database class to store food entries locally.

## License

    Copyright 2026 Albi Zhaku

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
