package com.bc.ceres.selection.support;

import com.bc.ceres.selection.Selection;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.Transferable;

/**
 * A handy base class for implementations of the {@link Selection} interface.
 * <p/>Clients only need to implement {@link #getSelectedValue()}
 * for single selection modes. For multiple selections,
 * {@link #getSelectedValues()} will need to be overridden.
 *
 * @author Norman Fomferra
 * @since Ceres 0.10
 */
public abstract class AbstractSelection implements Selection {

    protected AbstractSelection() {
    }

    @Override
    public Object[] getSelectedValues() {
        if (getSelectedValue() != null) {
            return new Object[]{getSelectedValue()};
        } else {
            return new Object[0];
        }
    }

    @Override
    public boolean isEmpty() {
        return getSelectedValue() == null;
    }

    /**
     * The default implementation returns an empty string.
     *
     * @return An empty string.
     */
    @Override
    public String getPresentationName() {
        return "";
    }

    /**
     * The default implementation returns {@code null}.
     *
     * @param snapshot If {@code true}, the returned {@link Transferable} should hold a copy-of rather than a
     *                 reference-to the selection.
     *
     * @return {@code null} by default.
     */
    @Override
    public Transferable createTransferable(boolean snapshot) {
        return null;
    }

    /**
     * Notifies this object that it is no longer the clipboard owner.
     * This method will be called when another application or another
     * object within this application asserts ownership of the clipboard.
     * <p/>
     * The default implementation does nothing.
     *
     * @param clipboard the clipboard that is no longer owned
     * @param contents  the contents which this owner had placed on the clipboard
     */
    @Override
    public void lostOwnership(Clipboard clipboard, Transferable contents) {
    }

    @SuppressWarnings({"CloneDoesntDeclareCloneNotSupportedException"})
    @Override
    public AbstractSelection clone() {
        try {
            return (AbstractSelection) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(e);
        }
    }
}