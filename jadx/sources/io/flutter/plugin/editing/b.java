package io.flutter.plugin.editing;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Build;
import android.os.Bundle;
import android.text.DynamicLayout;
import android.text.Editable;
import android.text.Layout;
import android.text.Selection;
import android.text.TextPaint;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputMethodManager;
import io.flutter.embedding.android.m;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.j.n;
import io.flutter.plugin.editing.c;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BaseInputConnection implements c.b {

    /* renamed from: a  reason: collision with root package name */
    private final View f524a;

    /* renamed from: b  reason: collision with root package name */
    private final int f525b;

    /* renamed from: c  reason: collision with root package name */
    private final n f526c;

    /* renamed from: d  reason: collision with root package name */
    private final c f527d;
    private final EditorInfo e;
    private ExtractedTextRequest f;
    private boolean g;
    private CursorAnchorInfo.Builder h;
    private ExtractedText i;
    private InputMethodManager j;
    private final Layout k;
    private a l;
    private final m m;
    private int n;

    public b(View view, int i, n nVar, m mVar, c cVar, EditorInfo editorInfo) {
        this(view, i, nVar, mVar, cVar, editorInfo, new FlutterJNI());
    }

    public b(View view, int i, n nVar, m mVar, c cVar, EditorInfo editorInfo, FlutterJNI flutterJNI) {
        super(view, true);
        this.g = false;
        this.i = new ExtractedText();
        this.n = 0;
        this.f524a = view;
        this.f525b = i;
        this.f526c = nVar;
        this.f527d = cVar;
        cVar.a(this);
        this.e = editorInfo;
        this.m = mVar;
        this.l = new a(flutterJNI);
        this.k = new DynamicLayout(cVar, new TextPaint(), Integer.MAX_VALUE, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        this.j = (InputMethodManager) view.getContext().getSystemService("input_method");
    }

    private boolean b(int i) {
        if (i == 16908319) {
            setSelection(0, this.f527d.length());
            return true;
        } else if (i == 16908320) {
            int selectionStart = Selection.getSelectionStart(this.f527d);
            int selectionEnd = Selection.getSelectionEnd(this.f527d);
            if (selectionStart != selectionEnd) {
                int min = Math.min(selectionStart, selectionEnd);
                int max = Math.max(selectionStart, selectionEnd);
                ((ClipboardManager) this.f524a.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", this.f527d.subSequence(min, max)));
                this.f527d.delete(min, max);
                setSelection(min, min);
            }
            return true;
        } else if (i == 16908321) {
            int selectionStart2 = Selection.getSelectionStart(this.f527d);
            int selectionEnd2 = Selection.getSelectionEnd(this.f527d);
            if (selectionStart2 != selectionEnd2) {
                ((ClipboardManager) this.f524a.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", this.f527d.subSequence(Math.min(selectionStart2, selectionEnd2), Math.max(selectionStart2, selectionEnd2))));
            }
            return true;
        } else if (i == 16908322) {
            ClipData primaryClip = ((ClipboardManager) this.f524a.getContext().getSystemService("clipboard")).getPrimaryClip();
            if (primaryClip != null) {
                CharSequence coerceToText = primaryClip.getItemAt(0).coerceToText(this.f524a.getContext());
                int max2 = Math.max(0, Selection.getSelectionStart(this.f527d));
                int max3 = Math.max(0, Selection.getSelectionEnd(this.f527d));
                int min2 = Math.min(max2, max3);
                int max4 = Math.max(max2, max3);
                if (min2 != max4) {
                    this.f527d.delete(min2, max4);
                }
                this.f527d.insert(min2, coerceToText);
                int length = min2 + coerceToText.length();
                setSelection(length, length);
            }
            return true;
        } else {
            return false;
        }
    }

    private CursorAnchorInfo c() {
        if (Build.VERSION.SDK_INT < 21) {
            return null;
        }
        CursorAnchorInfo.Builder builder = this.h;
        if (builder == null) {
            this.h = new CursorAnchorInfo.Builder();
        } else {
            builder.reset();
        }
        this.h.setSelectionRange(this.f527d.g(), this.f527d.f());
        int e = this.f527d.e();
        int d2 = this.f527d.d();
        if (e < 0 || d2 <= e) {
            this.h.setComposingText(-1, "");
        } else {
            this.h.setComposingText(e, this.f527d.toString().subSequence(e, d2));
        }
        return this.h.build();
    }

    private ExtractedText d(ExtractedTextRequest extractedTextRequest) {
        ExtractedText extractedText = this.i;
        extractedText.startOffset = 0;
        extractedText.partialStartOffset = -1;
        extractedText.partialEndOffset = -1;
        extractedText.selectionStart = this.f527d.g();
        this.i.selectionEnd = this.f527d.f();
        this.i.text = (extractedTextRequest == null || (extractedTextRequest.flags & 1) == 0) ? this.f527d.toString() : this.f527d;
        return this.i;
    }

    private boolean e(boolean z, boolean z2) {
        int selectionStart = Selection.getSelectionStart(this.f527d);
        int selectionEnd = Selection.getSelectionEnd(this.f527d);
        boolean z3 = false;
        if (selectionStart < 0 || selectionEnd < 0) {
            return false;
        }
        int max = z ? Math.max(this.l.b(this.f527d, selectionEnd), 0) : Math.min(this.l.a(this.f527d, selectionEnd), this.f527d.length());
        if (selectionStart == selectionEnd && !z2) {
            z3 = true;
        }
        if (z3) {
            setSelection(max, max);
        } else {
            setSelection(selectionStart, max);
        }
        return true;
    }

    private boolean g(boolean z, boolean z2) {
        int selectionStart = Selection.getSelectionStart(this.f527d);
        int selectionEnd = Selection.getSelectionEnd(this.f527d);
        boolean z3 = false;
        if (selectionStart < 0 || selectionEnd < 0) {
            return false;
        }
        if (selectionStart == selectionEnd && !z2) {
            z3 = true;
        }
        beginBatchEdit();
        if (z3) {
            if (z) {
                Selection.moveUp(this.f527d, this.k);
            } else {
                Selection.moveDown(this.f527d, this.k);
            }
            int selectionStart2 = Selection.getSelectionStart(this.f527d);
            setSelection(selectionStart2, selectionStart2);
        } else {
            if (z) {
                Selection.extendUp(this.f527d, this.k);
            } else {
                Selection.extendDown(this.f527d, this.k);
            }
            setSelection(Selection.getSelectionStart(this.f527d), Selection.getSelectionEnd(this.f527d));
        }
        endBatchEdit();
        return true;
    }

    @Override // io.flutter.plugin.editing.c.b
    public void a(boolean z, boolean z2, boolean z3) {
        this.j.updateSelection(this.f524a, this.f527d.g(), this.f527d.f(), this.f527d.e(), this.f527d.d());
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        ExtractedTextRequest extractedTextRequest = this.f;
        if (extractedTextRequest != null) {
            this.j.updateExtractedText(this.f524a, extractedTextRequest.token, d(extractedTextRequest));
        }
        if (this.g) {
            this.j.updateCursorAnchorInfo(this.f524a, c());
        }
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean beginBatchEdit() {
        this.f527d.b();
        this.n++;
        return super.beginBatchEdit();
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean clearMetaKeyStates(int i) {
        return super.clearMetaKeyStates(i);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public void closeConnection() {
        super.closeConnection();
        this.f527d.j(this);
        while (this.n > 0) {
            endBatchEdit();
            this.n--;
        }
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean commitText(CharSequence charSequence, int i) {
        return super.commitText(charSequence, i);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int i, int i2) {
        if (this.f527d.g() == -1) {
            return true;
        }
        return super.deleteSurroundingText(i, i2);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(int i, int i2) {
        return super.deleteSurroundingTextInCodePoints(i, i2);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean endBatchEdit() {
        boolean endBatchEdit = super.endBatchEdit();
        this.n--;
        this.f527d.c();
        return endBatchEdit;
    }

    public boolean f(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            if (keyEvent.getAction() == 1 && (keyEvent.getKeyCode() == 59 || keyEvent.getKeyCode() == 60)) {
                int selectionEnd = Selection.getSelectionEnd(this.f527d);
                setSelection(selectionEnd, selectionEnd);
                return true;
            }
            return false;
        } else if (keyEvent.getKeyCode() == 21) {
            return e(true, keyEvent.isShiftPressed());
        } else {
            if (keyEvent.getKeyCode() == 22) {
                return e(false, keyEvent.isShiftPressed());
            }
            if (keyEvent.getKeyCode() == 19) {
                return g(true, keyEvent.isShiftPressed());
            }
            if (keyEvent.getKeyCode() == 20) {
                return g(false, keyEvent.isShiftPressed());
            }
            if (keyEvent.getKeyCode() == 66 || keyEvent.getKeyCode() == 160) {
                EditorInfo editorInfo = this.e;
                if ((131072 & editorInfo.inputType) == 0) {
                    performEditorAction(editorInfo.imeOptions & 255);
                    return true;
                }
            }
            int selectionStart = Selection.getSelectionStart(this.f527d);
            int selectionEnd2 = Selection.getSelectionEnd(this.f527d);
            int unicodeChar = keyEvent.getUnicodeChar();
            if (selectionStart < 0 || selectionEnd2 < 0 || unicodeChar == 0) {
                return false;
            }
            int min = Math.min(selectionStart, selectionEnd2);
            int max = Math.max(selectionStart, selectionEnd2);
            beginBatchEdit();
            if (min != max) {
                this.f527d.delete(min, max);
            }
            this.f527d.insert(min, (CharSequence) String.valueOf((char) unicodeChar));
            int i = min + 1;
            setSelection(i, i);
            endBatchEdit();
            return true;
        }
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean finishComposingText() {
        return super.finishComposingText();
    }

    @Override // android.view.inputmethod.BaseInputConnection
    public Editable getEditable() {
        return this.f527d;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public ExtractedText getExtractedText(ExtractedTextRequest extractedTextRequest, int i) {
        boolean z = (i & 1) != 0;
        if (z == (this.f == null)) {
            StringBuilder sb = new StringBuilder();
            sb.append("The input method toggled text monitoring ");
            sb.append(z ? "on" : "off");
            c.a.b.a("InputConnectionAdaptor", sb.toString());
        }
        this.f = z ? extractedTextRequest : null;
        return d(extractedTextRequest);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean performContextMenuAction(int i) {
        beginBatchEdit();
        boolean b2 = b(i);
        endBatchEdit();
        return b2;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean performEditorAction(int i) {
        if (i == 0) {
            this.f526c.m(this.f525b);
        } else if (i == 1) {
            this.f526c.e(this.f525b);
        } else if (i == 2) {
            this.f526c.d(this.f525b);
        } else if (i == 3) {
            this.f526c.j(this.f525b);
        } else if (i == 4) {
            this.f526c.k(this.f525b);
        } else if (i == 5) {
            this.f526c.f(this.f525b);
        } else if (i != 7) {
            this.f526c.c(this.f525b);
        } else {
            this.f526c.h(this.f525b);
        }
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean performPrivateCommand(String str, Bundle bundle) {
        this.f526c.g(this.f525b, str, bundle);
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean requestCursorUpdates(int i) {
        if (Build.VERSION.SDK_INT < 21) {
            return false;
        }
        if ((i & 1) != 0) {
            this.j.updateCursorAnchorInfo(this.f524a, c());
        }
        boolean z = (i & 2) != 0;
        if (z != this.g) {
            StringBuilder sb = new StringBuilder();
            sb.append("The input method toggled cursor monitoring ");
            sb.append(z ? "on" : "off");
            c.a.b.a("InputConnectionAdaptor", sb.toString());
        }
        this.g = z;
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean sendKeyEvent(KeyEvent keyEvent) {
        return this.m.c(keyEvent);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean setComposingRegion(int i, int i2) {
        return super.setComposingRegion(i, i2);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean setComposingText(CharSequence charSequence, int i) {
        beginBatchEdit();
        boolean commitText = charSequence.length() == 0 ? super.commitText(charSequence, i) : super.setComposingText(charSequence, i);
        endBatchEdit();
        return commitText;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean setSelection(int i, int i2) {
        beginBatchEdit();
        boolean selection = super.setSelection(i, i2);
        endBatchEdit();
        return selection;
    }
}
