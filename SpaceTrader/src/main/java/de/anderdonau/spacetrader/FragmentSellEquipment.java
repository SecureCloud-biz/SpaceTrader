/*
 * Copyright (c) 2014. Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan. 
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna. 
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus. 
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package de.anderdonau.spacetrader;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import de.anderdonau.spacetrader.DataTypes.Ship;

public class FragmentSellEquipment extends Fragment {
	GameState gameState;

	public FragmentSellEquipment(GameState gameState) {
		this.gameState = gameState;
	}

	@SuppressWarnings("ConstantConditions")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		final View rootView = inflater.inflate(R.layout.fragment_sell_equipment, container, false);
		TextView tv;
		Button btn;
		Ship Ship = gameState.Ship;
		int i;

		tv = (TextView) rootView.findViewById(R.id.txtSellEquipmentCash);
		tv.setText(String.format("Cash: %d cr.", gameState.Credits));

		for (i = 0; i < GameState.MAXWEAPON; ++i) {
			btn = (Button) rootView.findViewById(i == 0 ? R.id.btnSellEquipmentWeapon1 :
			                                     i == 1 ? R.id.btnSellEquipmentWeapon2 :
			                                     R.id.btnSellEquipmentWeapon3
			);
			if (Ship.weapon[i] >= 0) {
				tv = (TextView) rootView.findViewById(i == 0 ? R.id.txtSellEquipmentWeapon1 :
				                                      i == 1 ? R.id.txtSellEquipmentWeapon2 :
				                                      R.id.txtSellEquipmentWeapon3
				);
				tv.setText(gameState.Weapons.mWeapons[Ship.weapon[i]].name);
				tv.setVisibility(View.VISIBLE);

				tv = (TextView) rootView.findViewById(i == 0 ? R.id.txtSellEquipmentPriceWeapon1 :
				                                      i == 1 ? R.id.txtSellEquipmentPriceWeapon2 :
				                                      R.id.txtSellEquipmentPriceWeapon3
				);
				tv.setText(String.format("%d cr.", gameState.WEAPONSELLPRICE(i)));
				tv.setVisibility(View.VISIBLE);

				btn.setVisibility(View.VISIBLE);
			} else {
				tv = (TextView) rootView.findViewById(i == 0 ? R.id.txtSellEquipmentPriceWeapon1 :
				                                      i == 1 ? R.id.txtSellEquipmentPriceWeapon2 :
				                                      R.id.txtSellEquipmentPriceWeapon3
				);
				tv.setVisibility(View.INVISIBLE);
				btn.setVisibility(View.INVISIBLE);
				tv = (TextView) rootView.findViewById(i == 0 ? R.id.txtSellEquipmentWeapon1 :
				                                      i == 1 ? R.id.txtSellEquipmentWeapon2 :
				                                      R.id.txtSellEquipmentWeapon3
				);
				tv.setVisibility(View.INVISIBLE);
				tv.setText("");
			}
		}

		for (i = 0; i < GameState.MAXSHIELD; ++i) {
			btn = (Button) rootView.findViewById(i == 0 ? R.id.btnSellEquipmentShield1 :
			                                     i == 1 ? R.id.btnSellEquipmentShield2 :
			                                     R.id.btnSellEquipmentShield3
			);
			if (Ship.shield[i] >= 0) {
				tv = (TextView) rootView.findViewById(i == 0 ? R.id.txtSellEquipmentShield1 :
				                                      i == 1 ? R.id.txtSellEquipmentShield2 :
				                                      R.id.txtSellEquipmentShield3
				);
				tv.setText(gameState.Shields.mShields[Ship.shield[i]].name);
				tv.setVisibility(View.VISIBLE);

				tv = (TextView) rootView.findViewById(i == 0 ? R.id.txtSellEquipmentPriceShield1 :
				                                      i == 1 ? R.id.txtSellEquipmentPriceShield2 :
				                                      R.id.txtSellEquipmentPriceShield3
				);
				tv.setText(String.format("%d cr.", gameState.SHIELDSELLPRICE(i)));
				tv.setVisibility(View.VISIBLE);

				btn.setVisibility(View.VISIBLE);
			} else {
				tv = (TextView) rootView.findViewById(i == 0 ? R.id.txtSellEquipmentPriceShield1 :
				                                      i == 1 ? R.id.txtSellEquipmentPriceShield2 :
				                                      R.id.txtSellEquipmentPriceShield3
				);
				tv.setVisibility(View.INVISIBLE);
				btn.setVisibility(View.INVISIBLE);
				tv = (TextView) rootView.findViewById(i == 0 ? R.id.txtSellEquipmentShield1 :
				                                      i == 1 ? R.id.txtSellEquipmentShield2 :
				                                      R.id.txtSellEquipmentShield3
				);
				tv.setVisibility(View.INVISIBLE);
				tv.setText("");
			}
		}

		for (i = 0; i < GameState.MAXGADGET; ++i) {
			btn = (Button) rootView.findViewById(i == 0 ? R.id.btnSellEquipmentGadget1 :
			                                     i == 1 ? R.id.btnSellEquipmentGadget2 :
			                                     R.id.btnSellEquipmentGadget3
			);
			if (Ship.gadget[i] >= 0) {
				tv = (TextView) rootView.findViewById(i == 0 ? R.id.txtSellEquipmentGadget1 :
				                                      i == 1 ? R.id.txtSellEquipmentGadget2 :
				                                      R.id.txtSellEquipmentGadget3
				);
				tv.setText(gameState.Gadgets.mGadgets[Ship.gadget[i]].name);
				tv.setVisibility(View.VISIBLE);

				tv = (TextView) rootView.findViewById(i == 0 ? R.id.txtSellEquipmentPriceGadget1 :
				                                      i == 1 ? R.id.txtSellEquipmentPriceGadget2 :
				                                      R.id.txtSellEquipmentPriceGadget3
				);
				tv.setText(String.format("%d cr.", gameState.GADGETSELLPRICE(i)));
				tv.setVisibility(View.VISIBLE);

				btn.setVisibility(View.VISIBLE);
			} else {
				tv = (TextView) rootView.findViewById(i == 0 ? R.id.txtSellEquipmentPriceGadget1 :
				                                      i == 1 ? R.id.txtSellEquipmentPriceGadget2 :
				                                      R.id.txtSellEquipmentPriceGadget3
				);
				tv.setVisibility(View.INVISIBLE);
				btn.setVisibility(View.INVISIBLE);
				tv = (TextView) rootView.findViewById(i == 0 ? R.id.txtSellEquipmentGadget1 :
				                                      i == 1 ? R.id.txtSellEquipmentGadget2 :
				                                      R.id.txtSellEquipmentGadget3
				);
				tv.setText("");
				tv.setVisibility(View.INVISIBLE);
			}
		}

		return rootView;
	}
}
