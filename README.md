# Koko User Guide

Koko is a simple command-line task manager that helps you track to-dos, deadlines, and events. You interact with Koko by typing commands in a single line.

---

## Quick Start

1. Launch Koko.
2. Type commands into the input box or console.
3. Press **Enter** (or click **Send**) to execute.

Example:
```
todo borrow book
```
---

## Features

---

### 1. Add a To-Do Task: `todo`

Adds a task with a description.

**Format**
```
todo DESCRIPTION
```

**Example**
```
todo finish CS2103 tutorial
```

---

### 2. Add a Deadline Task: `deadline`

Adds a task with a description and a deadline time.

**Format**
```
deadline DESCRIPTION /by dd/MM/yyyy HHmm
```

**Example**
```
deadline submit assignment /by 19/03/2026 2359
```

---

### 4. Add an Event Task: `event`

Adds a task with a description, a start time, and an end time.

**Format**
```
event DESCRIPTION /from dd/MM/yyyy HHmm /to dd/MM/yyyy HHmm
```

**Example**
```
event tutorial /from 19/03/2026 1400 /to 19/03/2026 1500
```

---

### 6. Mark a Task as Done: `mark`

Marks the task at the given index as completed.

**Format**
```
mark INDEX
```

**Example**
```
mark 2
```

**Notes**
- `INDEX` refers to the task number shown in the task list.

---

### 7. Unmark a Task: `unmark`

Marks the task at the given index as not completed.

**Format**
```
unmark INDEX
```

**Example**
```
unmark 2
```
---

### 8. Delete a Task: `delete`

Deletes the task at the given index.

**Format**
```
delete INDEX
```

**Example**
```
delete 3
```

---

### 9. Find Tasks by Keyword: `find`

Searches for tasks containing the given keyword.

**Format**
```
find KEYWORD
```

**Example**
```
find cs2103
```

---

### 10. Exit the Application: `bye`

Exits Koko.

**Format**
```
bye
```
